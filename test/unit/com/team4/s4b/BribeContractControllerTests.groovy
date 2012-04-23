package com.team4.s4b



import org.junit.*
import grails.test.mixin.*
import com.team4.s4b.domain.BribeContract
import com.team4.s4b.controller.BribeContractController

@TestFor(BribeContractController)
@Mock(BribeContract)
class BribeContractControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/bribeContract/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.bribeContractInstanceList.size() == 0
        assert model.bribeContractInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.bribeContractInstance != null
    }

    void testSave() {
        controller.save()

        assert model.bribeContractInstance != null
        assert view == '/bribeContract/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/bribeContract/show/1'
        assert controller.flash.message != null
        assert BribeContract.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/bribeContract/list'


        populateValidParams(params)
        def bribeContract = new BribeContract(params)

        assert bribeContract.save() != null

        params.id = bribeContract.id

        def model = controller.show()

        assert model.bribeContractInstance == bribeContract
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/bribeContract/list'


        populateValidParams(params)
        def bribeContract = new BribeContract(params)

        assert bribeContract.save() != null

        params.id = bribeContract.id

        def model = controller.edit()

        assert model.bribeContractInstance == bribeContract
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/bribeContract/list'

        response.reset()


        populateValidParams(params)
        def bribeContract = new BribeContract(params)

        assert bribeContract.save() != null

        // test invalid parameters in update
        params.id = bribeContract.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/bribeContract/edit"
        assert model.bribeContractInstance != null

        bribeContract.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/bribeContract/show/$bribeContract.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        bribeContract.clearErrors()

        populateValidParams(params)
        params.id = bribeContract.id
        params.version = -1
        controller.update()

        assert view == "/bribeContract/edit"
        assert model.bribeContractInstance != null
        assert model.bribeContractInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/bribeContract/list'

        response.reset()

        populateValidParams(params)
        def bribeContract = new BribeContract(params)

        assert bribeContract.save() != null
        assert BribeContract.count() == 1

        params.id = bribeContract.id

        controller.delete()

        assert BribeContract.count() == 0
        assert BribeContract.get(bribeContract.id) == null
        assert response.redirectedUrl == '/bribeContract/list'
    }
}
