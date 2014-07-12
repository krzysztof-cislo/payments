package pl.semacom.payments;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.semacom.payments.model.TestModel;

import javax.persistence.*;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/test")
public class TestController {

    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/list", method = GET)
    public
    @ResponseBody
    String list() {


        TypedQuery<TestModel> query = entityManager.createQuery("select t from TestModel t", TestModel.class);
        List<TestModel> resultList = query.getResultList();

        StringBuilder sb = new StringBuilder("ENTITY VALUES: ");

        for(TestModel testModel : resultList) {
            sb.append(testModel.getId()).append(" -> ").append(testModel.getValue()).append(", ");
        }

        return sb.toString();
    }

    @Transactional
    @RequestMapping(value = "/create/{id}/{value}", method = GET)
    public
    @ResponseBody
    String create(@PathVariable Long id, @PathVariable String value) {

        TestModel testModel = new TestModel();
        testModel.setId(id);
        testModel.setValue(value);

        entityManager.persist(testModel);

        return "ENTITY SAVED, ID: " + testModel.getId();
    }

    @Transactional
    @RequestMapping(value = "/update/{id}/{value}", method = GET)
    public
    @ResponseBody
    String update(@PathVariable Long id, @PathVariable String value) {

        TestModel testModel = entityManager.find(TestModel.class, id);
        testModel.setValue(value);

        entityManager.persist(testModel);

        return "ENTITY UPDATED";
    }

    @RequestMapping(value = "/get/{id}", method = GET)
    public
    @ResponseBody
    String get(@PathVariable Long id) {

        TestModel testModel = entityManager.find(TestModel.class, id);

        return "ENTITY'S VALUE: " + testModel.getValue();
    }

    @Transactional
    @RequestMapping(value = "/remove/{id}", method = GET)
    public
    @ResponseBody
    String remove(@PathVariable Long id) {

        TestModel testModel = entityManager.find(TestModel.class, id);
        entityManager.remove(testModel);

        return "ENTITY REMOVED";
    }


}
