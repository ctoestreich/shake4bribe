package com.team4.s4b



import org.junit.*
import grails.test.mixin.*
import com.team4.s4b.domain.BribePortfolio
import com.team4.s4b.controller.BribePortfolioController

@TestFor(BribePortfolioController)
@Mock(BribePortfolio)
class BribePortfolioControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/bribePortfolio/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.bribePortfolioInstanceList.size() == 0
        assert model.bribePortfolioInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.bribePortfolioInstance != null
    }

    void testSave() {
        controller.save()

        assert model.bribePortfolioInstance != null
        assert view == '/bribePortfolio/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/bribePortfolio/show/1'
        assert controller.flash.message != null
        assert BribePortfolio.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/bribePortfolio/list'


        populateValidParams(params)
        def bribePortfolio = new BribePortfolio(params)

        assert bribePortfolio.save() != null

        params.id = bribePortfolio.id

        def model = controller.show()

        assert model.bribePortfolioInstance == bribePortfolio
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/bribePortfolio/list'


        populateValidParams(params)
        def bribePortfolio = new BribePortfolio(params)

        assert bribePortfolio.save() != null

        params.id = bribePortfolio.id

        def model = controller.edit()

        assert model.bribePortfolioInstance == bribePortfolio
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/bribePortfolio/list'

        response.reset()


        populateValidParams(params)
        def bribePortfolio = new BribePortfolio(params)

        assert bribePortfolio.save() != null

        // test invalid parameters in update
        params.id = bribePortfolio.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/bribePortfolio/edit"
        assert model.bribePortfolioInstance != null

        bribePortfolio.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/bribePortfolio/show/$bribePortfolio.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        bribePortfolio.clearErrors()

        populateValidParams(params)
        params.id = bribePortfolio.id
        params.version = -1
        controller.update()

        assert view == "/bribePortfolio/edit"
        assert model.bribePortfolioInstance != null
        assert model.bribePortfolioInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/bribePortfolio/list'

        response.reset()

        populateValidParams(params)
        def bribePortfolio = new BribePortfolio(params)

        assert bribePortfolio.save() != null
        assert BribePortfolio.count() == 1

        params.id = bribePortfolio.id

        controller.delete()

        assert BribePortfolio.count() == 0
        assert BribePortfolio.get(bribePortfolio.id) == null
        assert response.redirectedUrl == '/bribePortfolio/list'
    }
}
