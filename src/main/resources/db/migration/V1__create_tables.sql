-- Создание таблицы ингредиентов
CREATE TABLE ingredients (
                             id BIGSERIAL PRIMARY KEY,
                             name VARCHAR(255) NOT NULL UNIQUE,
                             quantity INT NOT NULL,
                             min_level INT DEFAULT 10
);

-- Создание таблицы рецептов
CREATE TABLE recipes (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL UNIQUE
);

-- Создание таблицы для связи рецептов и ингредиентов
CREATE TABLE recipe_ingredients (
                                    recipe_id BIGINT NOT NULL REFERENCES recipes(id) ON DELETE CASCADE,
                                    ingredient_name VARCHAR(255) NOT NULL,
                                    quantity INT NOT NULL,
                                    PRIMARY KEY (recipe_id, ingredient_name)
);

-- Создание таблицы drink_orders
CREATE TABLE drink_orders (
                              id BIGSERIAL PRIMARY KEY,
                              recipe_id BIGINT NOT NULL REFERENCES recipes(id) ON DELETE CASCADE,
                              order_time TIMESTAMP NOT NULL
);