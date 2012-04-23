package com.team4.s4b



import org.junit.*
import grails.test.mixin.*
import com.team4.s4b.domain.Benefactor
import com.team4.s4b.controller.BenefactorController

@TestFor(BenefactorController)
@Mock(Benefactor)
class BenefactorControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/benefactor/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.benefactorInstanceList.size() == 0
        assert model.benefactorInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.benefactorInstance != null
    }

    void testSave() {
        controller.save()

        assert model.benefactorInstance != null
        assert view == '/benefactor/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/benefactor/show/1'
        assert controller.flash.message != null
        assert Benefactor.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/benefactor/list'


        populateValidParams(params)
        def benefactor = new Benefactor(params)

        assert benefactor.save() != null

        params.id = benefactor.id

        def model = controller.show()

        assert model.benefactorInstance == benefactor
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/benefactor/list'


        populateValidParams(params)
        def benefactor = new Benefactor(params)

        assert benefactor.save() != null

        params.id = benefactor.id

        def model = controller.edit()

        assert model.benefactorInstance == benefactor
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/benefactor/list'

        response.reset()


        populateValidParams(params)
        def benefactor = new Benefactor(params)

        assert benefactor.save() != null

        // test invalid parameters in update
        params.id = benefactor.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/benefactor/edit"
        assert model.benefactorInstance != null

        benefactor.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/benefactor/show/$benefactor.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        benefactor.clearErrors()

        populateValidParams(params)
        params.id = benefactor.id
        params.version = -1
        controller.update()

        assert view == "/benefactor/edit"
        assert model.benefactorInstance != null
        assert model.benefactorInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/benefactor/list'

        response.reset()

        populateValidParams(params)
        def benefactor = new Benefactor(params)

        assert benefactor.save() != null
        assert Benefactor.count() == 1

        params.id = benefactor.id

        controller.delete()

        assert Benefactor.count() == 0
        assert Benefactor.get(benefactor.id) == null
        assert response.redirectedUrl == '/benefactor/list'
    }
}
