INSERT INTO public.order_status ("name") VALUES
('COMPLETED'),
('PENDING'),
('IN_PROGRESS'),
('CANCELLED'),
('OPEN');

-- INSERTS FOR RESTAURANT TABLE
INSERT INTO public.restaurant (id, document, login, "name", "password", phone_number, profile_photo, "role") VALUES
(1, '123456789', 'restaurant1', 'Pizza Place', 'password1', '555-1234', 'https://example.com/photos/restaurant1.jpg', 'RESTAURANT'),
(2, '987654321', 'restaurant2', 'Salad Stop', 'password2', '555-5678', 'https://example.com/photos/restaurant2.jpg', 'RESTAURANT'),
(3, '192837465', 'restaurant3', 'Burger Joint', 'password3', '555-8765', 'https://example.com/photos/restaurant3.jpg', 'RESTAURANT'),
(4, '564738291', 'restaurant4', 'Snack Shack', 'password4', '555-4321', 'https://example.com/photos/restaurant4.jpg', 'RESTAURANT'),
(5, '246813579', 'restaurant5', 'Steak House', 'password5', '555-1357', 'https://example.com/photos/restaurant5.jpg', 'RESTAURANT');

-- INSERTS FOR PRODUCTS TABLE
INSERT INTO public.product (price, restaurant_id, "name", photo) VALUES
(12.99, 1, 'Margherita Pizza', 'https://example.com/photos/margherita_pizza.jpg'),
(15.50, 1, 'Pepperoni Pizza', 'https://example.com/photos/pepperoni_pizza.jpg'),
(8.75, 2, 'Caesar Salad', 'https://example.com/photos/caesar_salad.jpg'),
(10.00, 2, 'Greek Salad', 'https://example.com/photos/greek_salad.jpg'),
(14.99, 3, 'Cheeseburger', 'https://example.com/photos/cheeseburger.jpg'),
(13.50, 3, 'Veggie Burger', 'https://example.com/photos/veggie_burger.jpg'),
(5.00, 4, 'French Fries', 'https://example.com/photos/french_fries.jpg'),
(7.25, 4, 'Onion Rings', 'https://example.com/photos/onion_rings.jpg'),
(18.99, 5, 'Grilled Salmon', 'https://example.com/photos/grilled_salmon.jpg'),
(20.50, 5, 'Ribeye Steak', 'https://example.com/photos/ribeye_steak.jpg'),
(10.99, 1, 'BBQ Chicken Pizza', 'https://example.com/photos/bbq_chicken_pizza.jpg'),
(9.75, 1, 'Hawaiian Pizza', 'https://example.com/photos/hawaiian_pizza.jpg'),
(7.50, 2, 'Cobb Salad', 'https://example.com/photos/cobb_salad.jpg'),
(6.99, 2, 'Garden Salad', 'https://example.com/photos/garden_salad.jpg'),
(14.00, 3, 'Bacon Cheeseburger', 'https://example.com/photos/bacon_cheeseburger.jpg'),
(12.50, 3, 'Mushroom Swiss Burger', 'https://example.com/photos/mushroom_swiss_burger.jpg'),
(3.50, 4, 'Nachos', 'https://example.com/photos/nachos.jpg'),
(4.99, 4, 'Mozzarella Sticks', 'https://example.com/photos/mozzarella_sticks.jpg'),
(22.00, 5, 'T-Bone Steak', 'https://example.com/photos/tbone_steak.jpg'),
(24.50, 5, 'Grilled Ribeye', 'https://example.com/photos/grilled_ribeye.jpg');

-- INSERTS FOR DELIVERY_PERSON
INSERT INTO public.delivery_person (id, document, login, "name", "password", phone_number, "role") VALUES
(1, 'DLV123456', 'delivery1', 'John Doe', 'password1', '555-1111', 'DELIVERY_PERSON'),
(2, 'DLV654321', 'delivery2', 'Jane Smith', 'password2', '555-2222', 'DELIVERY_PERSON'),
(3, 'DLV112233', 'delivery3', 'Mike Johnson', 'password3', '555-3333', 'DELIVERY_PERSON'),
(4, 'DLV445566', 'delivery4', 'Emily Davis', 'password4', '555-4444', 'DELIVERY_PERSON'),
(5, 'DLV778899', 'delivery5', 'Chris Brown', 'password5', '555-5555', 'DELIVERY_PERSON');

-- INSERTS FOT CLIENT_PERSON
INSERT INTO public.client_person (id, document, login, "name", "password", phone_number, "role") VALUES
(1, 'CLI123456', 'client1', 'Alice Green', 'password1', '555-6666', 'CUSTOMER'),
(2, 'CLI654321', 'client2', 'Bob White', 'password2', '555-7777', 'CUSTOMER'),
(3, 'CLI112233', 'client3', 'Carol Black', 'password3', '555-8888', 'CUSTOMER'),
(4, 'CLI445566', 'client4', 'David Wilson', 'password4', '555-9999', 'CUSTOMER'),
(5, 'CLI778899', 'client5', 'Eve Adams', 'password5', '555-0000', 'CUSTOMER');

-- Inserting dummy data for orders
WITH order_data AS (
  SELECT 
    generate_series(1, 10000) AS order_id,
    floor(random() * 5) + 1 AS client_person_id,
    NOW() - INTERVAL '7 days' * random() AS created_at,
    floor(random() * 5) + 1 AS delivery_person_id,
    CASE 
      WHEN random() < 0.2 THEN 1 -- COMPLETED
      WHEN random() < 0.4 THEN 2 -- PENDING
      WHEN random() < 0.6 THEN 3 -- IN_PROGRESS
      WHEN random() < 0.8 THEN 4 -- CANCELLED
      ELSE 5 -- OPEN
    END AS order_status_id,
    floor(random() * 5) + 1 AS restaurant_id
)
INSERT INTO public.orders (id, client_person_id, created_at, delivery_person_id, order_status_id, restaurant_id)
SELECT 
  order_id,
  client_person_id,
  created_at,
  delivery_person_id,
  order_status_id,
  restaurant_id
FROM order_data;

-- Inserting dummy data for product_order
WITH product_data AS (
  SELECT 
    generate_series(1, 20000) AS product_order_id,
    floor(random() * 10000) + 1 AS order_id,
    CASE 
      WHEN random() < 0.3 THEN 1 -- Product ID 1
      WHEN random() < 0.5 THEN 2 -- Product ID 2
      WHEN random() < 0.7 THEN 3 -- Product ID 3
      WHEN random() < 0.9 THEN 4 -- Product ID 4
      ELSE 5 -- Product ID 5
    END AS product_id,
    floor(random() * 5) + 1 AS quantity
)
INSERT INTO public.product_order (id, order_id, product_id, quantity)
SELECT 
  product_order_id,
  order_id,
  product_id,
  quantity
FROM product_data;

