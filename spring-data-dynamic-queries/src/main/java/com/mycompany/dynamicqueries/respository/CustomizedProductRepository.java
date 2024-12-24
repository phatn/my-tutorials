package com.mycompany.dynamicqueries.respository;

import com.mycompany.dynamicqueries.domain.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CustomizedProductRepository {

    private final EntityManager entityManager;

    public CustomizedProductRepository(JpaContext context) {
        this.entityManager = context.getEntityManagerByManagedType(Product.class);
    }

    public List<Product> find(Map<String, String> filters) {
        StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Product p");
        if (filters != null && !filters.isEmpty()) {
            queryBuilder.append(" WHERE ");
            filters.forEach((key, value) -> queryBuilder.append(key).append(" = :").append(key).append(" AND "));
            int lastIndex = queryBuilder.lastIndexOf(" AND ");
            queryBuilder.delete(lastIndex, lastIndex + queryBuilder.length());
        }

        TypedQuery<Product> query = entityManager.createQuery(queryBuilder.toString(), Product.class);
        if (filters != null && !filters.isEmpty()) {
            filters.forEach(query::setParameter);
        }
        return query.getResultList();
    }
}
