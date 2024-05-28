package br.com.delivery.deliveryapi.repositories;

import br.com.delivery.deliveryapi.model.Product;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = """
            SELECT
                p.*
            FROM
                product p
            LEFT JOIN (
                SELECT
                    po.product_id,
                    SUM(po.quantity) AS quantity
                FROM
                    product_order po
                JOIN
                    orders o ON po.order_id = o.id
                WHERE
                    o.order_status_id = 1
                    AND o.created_at > current_date - INTERVAL '7 days'
                GROUP BY
                    po.product_id
            ) AS po ON po.product_id = p.id
            GROUP BY
                p.id
            ORDER BY
                COALESCE(SUM(po.quantity), 0) DESC
            LIMIT 30;
            """, nativeQuery = true)
    List<Map<String, Object>> getMostSoldLastWeek();
}
