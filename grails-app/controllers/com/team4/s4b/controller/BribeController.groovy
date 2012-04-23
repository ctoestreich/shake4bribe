package com.team4.s4b.controller

import org.springframework.dao.DataIntegrityViolationException
import com.team4.s4b.domain.Bribe

class BribeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [bribeInstanceList: Bribe.list(params), bribeInstanceTotal: Bribe.count()]
    }

    def create() {
        [bribeInstance: new Bribe(params)]
    }

    def save() {
        def bribeInstance = new Bribe(params)
        if (!bribeInstance.save(flush: true)) {
            render(view: "create", model: [bribeInstance: bribeInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'bribe.label', default: 'Bribe'), bribeInstance.id])
        redirect(action: "show", id: bribeInstance.id)
    }

    def show() {
        def bribeInstance = Bribe.get(params.id)
        if (!bribeInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'bribe.label', default: 'Bribe'), params.id])
            redirect(action: "list")
            return
        }

        [bribeInstance: bribeInstance]
    }

    def edit() {
        def bribeInstance = Bribe.get(params.id)
        if (!bribeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bribe.label', default: 'Bribe'), params.id])
            redirect(action: "list")
            return
        }

        [bribeInstance: bribeInstance]
    }

    def update() {
        def bribeInstance = Bribe.get(params.id)
        if (!bribeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bribe.label', default: 'Bribe'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (bribeInstance.version > version) {
                bribeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'bribe.label', default: 'Bribe')] as Object[],
                          "Another user has updated this Bribe while you were editing")
                render(view: "edit", model: [bribeInstance: bribeInstance])
                return
            }
        }

        bribeInstance.properties = params

        if (!bribeInstance.save(flush: true)) {
            render(view: "edit", model: [bribeInstance: bribeInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'bribe.label', default: 'Bribe'), bribeInstance.id])
        redirect(action: "show", id: bribeInstance.id)
    }

    def delete() {
        def bribeInstance = Bribe.get(params.id)
        if (!bribeInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'bribe.label', default: 'Bribe'), params.id])
            redirect(action: "list")
            return
        }

        try {
            bribeInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'bribe.label', default: 'Bribe'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'bribe.label', default: 'Bribe'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
