package com.team4.s4b.controller

import org.springframework.dao.DataIntegrityViolationException
import com.team4.s4b.domain.Recipient

class RecipientController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [recipientInstanceList: Recipient.list(params), recipientInstanceTotal: Recipient.count()]
    }

    def create() {
        [recipientInstance: new Recipient(params)]
    }

    def save() {
        def recipientInstance = new Recipient(params)
        if (!recipientInstance.save(flush: true)) {
            render(view: "create", model: [recipientInstance: recipientInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'recipient.label', default: 'Recipient'), recipientInstance.id])
        redirect(action: "show", id: recipientInstance.id)
    }

    def show() {
        def recipientInstance = Recipient.get(params.id)
        if (!recipientInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'recipient.label', default: 'Recipient'), params.id])
            redirect(action: "list")
            return
        }

        [recipientInstance: recipientInstance]
    }

    def edit() {
        def recipientInstance = Recipient.get(params.id)
        if (!recipientInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'recipient.label', default: 'Recipient'), params.id])
            redirect(action: "list")
            return
        }

        [recipientInstance: recipientInstance]
    }

    def update() {
        def recipientInstance = Recipient.get(params.id)
        if (!recipientInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'recipient.label', default: 'Recipient'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (recipientInstance.version > version) {
                recipientInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'recipient.label', default: 'Recipient')] as Object[],
                          "Another user has updated this Recipient while you were editing")
                render(view: "edit", model: [recipientInstance: recipientInstance])
                return
            }
        }

        recipientInstance.properties = params

        if (!recipientInstance.save(flush: true)) {
            render(view: "edit", model: [recipientInstance: recipientInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'recipient.label', default: 'Recipient'), recipientInstance.id])
        redirect(action: "show", id: recipientInstance.id)
    }

    def delete() {
        def recipientInstance = Recipient.get(params.id)
        if (!recipientInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'recipient.label', default: 'Recipient'), params.id])
            redirect(action: "list")
            return
        }

        try {
            recipientInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'recipient.label', default: 'Recipient'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'recipient.label', default: 'Recipient'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
