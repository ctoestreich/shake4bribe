package com.team4.s4b.controller

import com.team4.s4b.domain.BribePortfolio
import org.springframework.dao.DataIntegrityViolationException

class BribePortfolioController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [bribePortfolioInstanceList: BribePortfolio.list(params), bribePortfolioInstanceTotal: BribePortfolio.count()]
    }

    def create() {
        [bribePortfolioInstance: new BribePortfolio(params)]
    }

    def save() {
        def bribePortfolioInstance = new BribePortfolio(params)
        if(!bribePortfolioInstance.save(flush: true)) {
            render(view: "create", model: [bribePortfolioInstance: bribePortfolioInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'bribePortfolio.label', default: 'BribePortfolio'), bribePortfolioInstance.id])
        redirect(action: "show", id: bribePortfolioInstance.id)
    }

    def show() {
        def bribePortfolioInstance = BribePortfolio.get(params.id)
        if(!bribePortfolioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bribePortfolio.label', default: 'BribePortfolio'), params.id])
            redirect(action: "list")
            return
        }

        [bribePortfolioInstance: bribePortfolioInstance]
    }

    def edit() {
        def bribePortfolioInstance = BribePortfolio.get(params.id)
        if(!bribePortfolioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bribePortfolio.label', default: 'BribePortfolio'), params.id])
            redirect(action: "list")
            return
        }

        [bribePortfolioInstance: bribePortfolioInstance]
    }

    def update() {
        def bribePortfolioInstance = BribePortfolio.get(params.id)
        if(!bribePortfolioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bribePortfolio.label', default: 'BribePortfolio'), params.id])
            redirect(action: "list")
            return
        }

        if(params.version) {
            def version = params.version.toLong()
            if(bribePortfolioInstance.version > version) {
                bribePortfolioInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                                                          [message(code: 'bribePortfolio.label', default: 'BribePortfolio')] as Object[],
                                                          "Another user has updated this BribePortfolio while you were editing")
                render(view: "edit", model: [bribePortfolioInstance: bribePortfolioInstance])
                return
            }
        }

        bribePortfolioInstance.properties = params

        if(!bribePortfolioInstance.save(flush: true)) {
            render(view: "edit", model: [bribePortfolioInstance: bribePortfolioInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'bribePortfolio.label', default: 'BribePortfolio'), bribePortfolioInstance.id])
        redirect(action: "show", id: bribePortfolioInstance.id)
    }

    def delete() {
        def bribePortfolioInstance = BribePortfolio.get(params.id)
        if(!bribePortfolioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bribePortfolio.label', default: 'BribePortfolio'), params.id])
            redirect(action: "list")
            return
        }

        try {
            bribePortfolioInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'bribePortfolio.label', default: 'BribePortfolio'), params.id])
            redirect(action: "list")
        }
        catch(DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'bribePortfolio.label', default: 'BribePortfolio'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
