package com.team4.s4b.controller

import org.springframework.dao.DataIntegrityViolationException
import com.team4.s4b.domain.BribeContract

class BribeContractController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [bribeContractInstanceList: BribeContract.list(params), bribeContractInstanceTotal: BribeContract.count()]
    }

    def create() {
        [bribeContractInstance: new BribeContract(params)]
    }

    def save() {
        def bribeContractInstance = new BribeContract(params)
        if (!bribeContractInstance.save(flush: true)) {
            render(view: "create", model: [bribeContractInstance: bribeContractInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'bribeContract.label', default: 'BribeContract'), bribeContractInstance.id])
        redirect(action: "show", id: bribeContractInstance.id)
    }

    def completeOpportunity(){
        def bribeContractInstance = BribeContract.get(params.id)
        if (!bribeContractInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bribeContract.label', default: 'BribeContract'), params.id])
            redirect(action: "list")
            return
        }
        bribeContractInstance.opportunityStatus = true
        bribeContractInstance.save()

        redirect(action: 'show', id: bribeContractInstance.id)
    }

    def completeBribe(){
        def bribeContractInstance = BribeContract.get(params.id)
        if (!bribeContractInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bribeContract.label', default: 'BribeContract'), params.id])
            redirect(action: "list")
            return
        }
        bribeContractInstance.bribeStatus = true
        bribeContractInstance.save()

        redirect(action: 'show', id: bribeContractInstance.id)
    }

    def completeContract(){
        def bribeContractInstance = BribeContract.get(params.id)
        if (!bribeContractInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bribeContract.label', default: 'BribeContract'), params.id])
            redirect(action: "list")
            return
        }
        bribeContractInstance.bribeStatus = true
        bribeContractInstance.opportunityStatus = true
        bribeContractInstance.save()

        redirect(action: 'show', id: bribeContractInstance.id)
    }

    def show() {
        def bribeContractInstance = BribeContract.get(params.id)
        if (!bribeContractInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'bribeContract.label', default: 'BribeContract'), params.id])
            redirect(action: "list")
            return
        }

        [bribeContractInstance: bribeContractInstance]
    }

    def edit() {
        def bribeContractInstance = BribeContract.get(params.id)
        if (!bribeContractInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bribeContract.label', default: 'BribeContract'), params.id])
            redirect(action: "list")
            return
        }

        [bribeContractInstance: bribeContractInstance]
    }

    def update() {
        def bribeContractInstance = BribeContract.get(params.id)
        if (!bribeContractInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'bribeContract.label', default: 'BribeContract'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (bribeContractInstance.version > version) {
                bribeContractInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'bribeContract.label', default: 'BribeContract')] as Object[],
                          "Another user has updated this BribeContract while you were editing")
                render(view: "edit", model: [bribeContractInstance: bribeContractInstance])
                return
            }
        }

        bribeContractInstance.properties = params

        if (!bribeContractInstance.save(flush: true)) {
            render(view: "edit", model: [bribeContractInstance: bribeContractInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'bribeContract.label', default: 'BribeContract'), bribeContractInstance.id])
        redirect(action: "show", id: bribeContractInstance.id)
    }

    def delete() {
        def bribeContractInstance = BribeContract.get(params.id)
        if (!bribeContractInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'bribeContract.label', default: 'BribeContract'), params.id])
            redirect(action: "list")
            return
        }

        try {
            bribeContractInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'bribeContract.label', default: 'BribeContract'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'bribeContract.label', default: 'BribeContract'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
