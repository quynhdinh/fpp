CREATE TABLE public.person (
    firstname VARCHAR NOT NULL,
    lastname VARCHAR NOT NULL,
    ssn VARCHAR NOT NULL,
    id BIGINT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.address (
    street VARCHAR NOT NULL,
    city VARCHAR NOT NULL,
    state VARCHAR NOT NULL,
    zip VARCHAR NOT NULL,
    id BIGINT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO public.person (firstname, lastname, ssn, id) VALUES
('John', 'Doe', '123-45-6789', 1),
('Jane', 'Smith', '987-65-4321', 2),
('Alice', 'Johnson', '456-78-9012', 3),
('Bob', 'Brown', '321-54-9876', 4);

INSERT INTO public.address (street, city, state, zip, id) VALUES
('123 Elm St', 'Springfield', 'IL', '62701', 1),
('456 Oak Ave', 'Metropolis', 'NY', '10001', 2),
('789 Pine Rd', 'Gotham', 'NJ', '07001', 3),
('101 Maple Blvd', 'Star City', 'CA', '90001', 4);