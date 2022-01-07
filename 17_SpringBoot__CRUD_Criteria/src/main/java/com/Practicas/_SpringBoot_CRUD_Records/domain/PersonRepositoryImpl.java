package com.Practicas._SpringBoot_CRUD_Records.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PersonRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    //dónde poner esto??????
    public static final String GREATER_THAN="greater";
    public static final String LESS_THAN="less";
    public static final String EQUAL="equal";
   //

    public List<Person> getData(HashMap<String, Object> conditions)
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query= cb.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field,value) ->
        {
            switch (field)
            {
                case "user":
                    predicates.add(cb.equal(root.get(field), (String)value));
                    break;
                case "name":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "surname":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "created_date":
                    String dateCondition=(String) conditions.get("dateCondition");
                    switch (dateCondition)
                    {
                        case GREATER_THAN:
                            predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
                            break;
                        case LESS_THAN:
                            predicates.add(cb.lessThan(root.<Date>get(field),(Date)value));
                            break;
                        case EQUAL:
                            predicates.add(cb.equal(root.<Date>get(field),(Date)value));
                            break;
                    }
                    break;
            }

        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}
