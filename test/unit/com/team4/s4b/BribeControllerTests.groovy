package com.team4.s4b



import org.junit.*
import grails.test.mixin.*
import com.team4.s4b.domain.Bribe
import com.team4.s4b.controller.BribeController

@TestFor(BribeController)
@Mock(Bribe)
class BribeControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/bribe/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.bribeInstanceList.size() == 0
        assert model.bribeInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.bribeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.bribeInstance != null
        assert view == '/bribe/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/bribe/show/1'
        assert controller.flash.message != null
        assert Bribe.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/bribe/list'


        populateValidParams(params)
        def bribe = new Bribe(params)

        assert bribe.save() != null

        params.id = bribe.id

        def model = controller.show()

        assert model.bribeInstance == bribe
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/bribe/list'


        populateValidParams(params)
        def bribe = new Bribe(params)

        assert bribe.save() != null

        params.id = bribe.id

        def model = controller.edit()

        assert model.bribeInstance == bribe
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/bribe/list'

        response.reset()


        populateValidParams(params)
        def bribe = new Bribe(params)

        assert bribe.save() != null

        // test invalid parameters in update
        params.id = bribe.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/bribe/edit"
        assert model.bribeInstance != null

        bribe.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/bribe/show/$bribe.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        bribe.clearErrors()

        populateValidParams(params)
        params.id = bribe.id
        params.version = -1
        controller.update()

        assert view == "/bribe/edit"
        assert model.bribeInstance != null
        assert model.bribeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/bribe/list'

        response.reset()

        populateValidParams(params)
        def bribe = new Bribe(params)

        assert bribe.save() != null
        assert Bribe.count() == 1

        params.id = bribe.id

        controller.delete()

        assert Bribe.count() == 0
        assert Bribe.get(bribe.id) == null
        assert response.redirectedUrl == '/bribe/list'
    }
}
