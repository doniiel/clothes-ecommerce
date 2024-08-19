DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS cart_items;
DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS shippers_products;
DROP TABLE IF EXISTS shippers;
DROP TABLE IF EXISTS order_table;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS address;

/* Table Address */
CREATE TABLE address(
                        address_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        city VARCHAR(255) NOT NULL,
                        country VARCHAR(255) NOT NULL,
                        pin_code INT NOT NULL,
                        street VARCHAR(255) NOT NULL,
                        house_number INT NOT NULL
) AUTO_INCREMENT = 1;

/* Table Users */
CREATE TABLE users(
                      user_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      firstname VARCHAR(255) NOT NULL,
                      lastname VARCHAR(255) NOT NULL,
                      username VARCHAR(255) NOT NULL UNIQUE,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL,
                      role VARCHAR(20) NOT NULL,
                      address_id BIGINT,
                      phone_number VARCHAR(10) NOT NULL UNIQUE,
                      gender VARCHAR(10) NOT NULL,
                      FOREIGN KEY (address_id) REFERENCES address(address_id)
) AUTO_INCREMENT = 1;

/* Table Category */
CREATE TABLE category(
                         category_id BIGINT AUTO_INCREMENT UNIQUE PRIMARY KEY,
                         name VARCHAR(255) NOT NULL UNIQUE
) AUTO_INCREMENT = 1;

/* Table Shipment */
CREATE TABLE shipment(
                         shipment_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         order_id BIGINT,
                         user_id BIGINT,
                         shipment_type VARCHAR(255) NOT NULL,
                         payment_method VARCHAR(255) NOT NULL,
                         delivery_cost DOUBLE(10,2) NOT NULL,
                         discount DOUBLE(10,2) NOT NULL,
                         total_price DOUBLE(10,2) NOT NULL,
                         FOREIGN KEY (order_id) REFERENCES order_product(order_id),
                         FOREIGN KEY (user_id) REFERENCES users(user_id)
) AUTO_INCREMENT = 1;

/* Table Product */
CREATE TABLE product(
                        product_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        price DOUBLE(10,2) NOT NULL,
                        description TEXT NOT NULL,
                        quantity INT NOT NULL,
                        category_id BIGINT NOT NULL,
                        shipment_id BIGINT NOT NULL,
                        FOREIGN KEY (category_id) REFERENCES category(category_id),
                        FOREIGN KEY (shipment_id) REFERENCES shipment(shipment_id)
) AUTO_INCREMENT = 1;

/* Table Order Product */
CREATE TABLE order_product(
                              order_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
                              user_id BIGINT NOT NULL,
                              order_date DATE NOT NULL,
                              shipping_address VARCHAR(255) NOT NULL,
                              price_total DOUBLE(10,2) NOT NULL,
                              status VARCHAR(50) NOT NULL,
                              FOREIGN KEY (user_id) REFERENCES users(user_id)
) AUTO_INCREMENT = 1;

/* Table Order Items */
CREATE TABLE order_items(
                            order_items_id BIGINT NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
                            order_id BIGINT NOT NULL,
                            product_id BIGINT NOT NULL,
                            discount INT,
                            order_product_price DOUBLE(10,2) NOT NULL,
                            quantity INT NOT NULL,
                            price_total DOUBLE(10,2) NOT NULL,
                            FOREIGN KEY (order_id) REFERENCES order_product(order_id),
                            FOREIGN KEY (product_id) REFERENCES product(product_id)
) AUTO_INCREMENT = 1;

/* Table Payment */
CREATE TABLE payment(
                        payment_id BIGINT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
                        order_id BIGINT NOT NULL,
                        payment_date DATE NOT NULL,
                        amount DOUBLE(10,2) NOT NULL,
                        payment_method VARCHAR(50) NOT NULL,
                        FOREIGN KEY (order_id) REFERENCES order_product(order_id)
) AUTO_INCREMENT = 1;

/* Table Review */
CREATE TABLE review(
                       review_id BIGINT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
                       product_id BIGINT NOT NULL,
                       user_id BIGINT NOT NULL,
                       rating INT NOT NULL,
                       comment TEXT,
                       review_date DATE NOT NULL,
                       FOREIGN KEY (product_id) REFERENCES product(product_id),
                       FOREIGN KEY (user_id) REFERENCES users(user_id)
) AUTO_INCREMENT = 1;

/* Table Shippers */
CREATE TABLE shippers(
                         shippers_id BIGINT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
                         company_name VARCHAR(100) NOT NULL,
                         phone VARCHAR(10) NOT NULL,
                         email VARCHAR(255) NOT NULL UNIQUE
) AUTO_INCREMENT = 1;

/* Table Shippers Product */
CREATE TABLE IF NOT EXISTS shippers_products (
                                                 shipper_id BIGINT NOT NULL,
                                                 product_id BIGINT NOT NULL,
                                                 PRIMARY KEY (shipper_id, product_id),
    FOREIGN KEY (shipper_id) REFERENCES shippers(shippers_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
    );

/* Table Cart */
CREATE TABLE cart(
                     cart_id BIGINT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
                     total_price DOUBLE(10,2) NOT NULL,
                     user_id BIGINT NOT NULL,
                     FOREIGN KEY (user_id) REFERENCES users(user_id)
) AUTO_INCREMENT = 1;

/* Table Cart Items */
CREATE Table cart_items(
                           cart_items_id BIGINT NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY,
                           discount DOUBLE(10,2) NOT NULL,
                           product_price DOUBLE(10,2) NOT NULL,
                           quantity INT NOT NULL,
                           cart_id BIGINT NOT NULL,
                           product_id BIGINT NOT NULL,
                           FOREIGN KEY (cart_id) REFERENCES cart(cart_id),
                           FOREIGN KEY (product_id) REFERENCES product(product_id)
) AUTO_INCREMENT = 1;
