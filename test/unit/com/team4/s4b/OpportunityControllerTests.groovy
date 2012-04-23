package com.team4.s4b



import org.junit.*
import grails.test.mixin.*
import com.team4.s4b.domain.Opportunity
import com.team4.s4b.controller.OpportunityController

@TestFor(OpportunityController)
@Mock(Opportunity)
class OpportunityControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/opportunity/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.opportunityInstanceList.size() == 0
        assert model.opportunityInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.opportunityInstance != null
    }

    void testSave() {
        controller.save()

        assert model.opportunityInstance != null
        assert view == '/opportunity/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/opportunity/show/1'
        assert controller.flash.message != null
        assert Opportunity.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/opportunity/list'


        populateValidParams(params)
        def opportunity = new Opportunity(params)

        assert opportunity.save() != null

        params.id = opportunity.id

        def model = controller.show()

        assert model.opportunityInstance == opportunity
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/opportunity/list'


        populateValidParams(params)
        def opportunity = new Opportunity(params)

        assert opportunity.save() != null

        params.id = opportunity.id

        def model = controller.edit()

        assert model.opportunityInstance == opportunity
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/opportunity/list'

        response.reset()


        populateValidParams(params)
        def opportunity = new Opportunity(params)

        assert opportunity.save() != null

        // test invalid parameters in update
        params.id = opportunity.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/opportunity/edit"
        assert model.opportunityInstance != null

        opportunity.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/opportunity/show/$opportunity.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        opportunity.clearErrors()

        populateValidParams(params)
        params.id = opportunity.id
        params.version = -1
        controller.update()

        assert view == "/opportunity/edit"
        assert model.opportunityInstance != null
        assert model.opportunityInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/opportunity/list'

        response.reset()

        populateValidParams(params)
        def opportunity = new Opportunity(params)

        assert opportunity.save() != null
        assert Opportunity.count() == 1

        params.id = opportunity.id

        controller.delete()

        assert Opportunity.count() == 0
        assert Opportunity.get(opportunity.id) == null
        assert response.redirectedUrl == '/opportunity/list'
    }
}
