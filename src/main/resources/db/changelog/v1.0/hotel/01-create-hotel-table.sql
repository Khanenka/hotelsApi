CREATE TABLE hotel (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       brand VARCHAR(255) NOT NULL,
                       description VARCHAR(255) NOT NULL,
                       houseNumber INT NOT NULL,
                       street VARCHAR(255) NOT NULL,
                       city VARCHAR(255) NOT NULL,
                       county VARCHAR(255) NOT NULL,
                       postCode VARCHAR(255) NOT NULL,
                       checkIn VARCHAR(255) NOT NULL,
                       checkOut VARCHAR(255) NOT NULL,
                       phone VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       amenities VARCHAR(255)
);
