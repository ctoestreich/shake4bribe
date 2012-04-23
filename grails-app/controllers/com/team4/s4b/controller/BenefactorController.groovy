package com.team4.s4b.controller

import org.springframework.dao.DataIntegrityViolationException
import com.team4.s4b.domain.Benefactor

class BenefactorController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [benefactorInstanceList: Benefactor.list(params), benefactorInstanceTotal: Benefactor.count()]
    }

    def create() {
        [benefactorInstance: new Benefactor(params)]
    }

    def save() {
        def benefactorInstance = new Benefactor(params)
        if (!benefactorInstance.save(flush: true)) {
            render(view: "create", model: [benefactorInstance: benefactorInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'benefactor.label', default: 'Benefactor'), benefactorInstance.id])
        redirect(action: "show", id: benefactorInstance.id)
    }

    def show() {
        def benefactorInstance = Benefactor.get(params.id)
        if (!benefactorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'benefactor.label', default: 'Benefactor'), params.id])
            redirect(action: "list")
            return
        }

        [benefactorInstance: benefactorInstance]
    }

    def edit() {
        def benefactorInstance = Benefactor.get(params.id)
        if (!benefactorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'benefactor.label', default: 'Benefactor'), params.id])
            redirect(action: "list")
            return
        }

        [benefactorInstance: benefactorInstance]
    }

    def update() {
        def benefactorInstance = Benefactor.get(params.id)
        if (!benefactorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'benefactor.label', default: 'Benefactor'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (benefactorInstance.version > version) {
                benefactorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'benefactor.label', default: 'Benefactor')] as Object[],
                          "Another user has updated this Benefactor while you were editing")
                render(view: "edit", model: [benefactorInstance: benefactorInstance])
                return
            }
        }

        benefactorInstance.properties = params

        if (!benefactorInstance.save(flush: true)) {
            render(view: "edit", model: [benefactorInstance: benefactorInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'benefactor.label', default: 'Benefactor'), benefactorInstance.id])
        redirect(action: "show", id: benefactorInstance.id)
    }

    def delete() {
        def benefactorInstance = Benefactor.get(params.id)
        if (!benefactorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'benefactor.label', default: 'Benefactor'), params.id])
            redirect(action: "list")
            return
        }

        try {
            benefactorInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'benefactor.label', default: 'Benefactor'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'benefactor.label', default: 'Benefactor'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
