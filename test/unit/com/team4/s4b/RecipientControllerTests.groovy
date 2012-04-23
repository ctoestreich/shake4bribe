package com.team4.s4b



import org.junit.*
import grails.test.mixin.*
import com.team4.s4b.domain.Recipient
import com.team4.s4b.controller.RecipientController

@TestFor(RecipientController)
@Mock(Recipient)
class RecipientControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/recipient/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.recipientInstanceList.size() == 0
        assert model.recipientInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.recipientInstance != null
    }

    void testSave() {
        controller.save()

        assert model.recipientInstance != null
        assert view == '/recipient/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/recipient/show/1'
        assert controller.flash.message != null
        assert Recipient.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/recipient/list'


        populateValidParams(params)
        def recipient = new Recipient(params)

        assert recipient.save() != null

        params.id = recipient.id

        def model = controller.show()

        assert model.recipientInstance == recipient
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/recipient/list'


        populateValidParams(params)
        def recipient = new Recipient(params)

        assert recipient.save() != null

        params.id = recipient.id

        def model = controller.edit()

        assert model.recipientInstance == recipient
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/recipient/list'

        response.reset()


        populateValidParams(params)
        def recipient = new Recipient(params)

        assert recipient.save() != null

        // test invalid parameters in update
        params.id = recipient.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/recipient/edit"
        assert model.recipientInstance != null

        recipient.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/recipient/show/$recipient.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        recipient.clearErrors()

        populateValidParams(params)
        params.id = recipient.id
        params.version = -1
        controller.update()

        assert view == "/recipient/edit"
        assert model.recipientInstance != null
        assert model.recipientInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/recipient/list'

        response.reset()

        populateValidParams(params)
        def recipient = new Recipient(params)

        assert recipient.save() != null
        assert Recipient.count() == 1

        params.id = recipient.id

        controller.delete()

        assert Recipient.count() == 0
        assert Recipient.get(recipient.id) == null
        assert response.redirectedUrl == '/recipient/list'
    }
}
