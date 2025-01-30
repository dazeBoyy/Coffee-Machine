-- Добавляем ингредиенты
INSERT INTO ingredients (name, quantity) VALUES
                                             ('water', 1000),
                                             ('coffee', 500),
                                             ('milk', 300);

-- Добавляем рецепты
INSERT INTO recipes (name) VALUES
                               ('espresso'),
                               ('americano'),
                               ('cappuccino');

-- Добавляем связки ингредиентов с рецептами
INSERT INTO recipe_ingredients (recipe_id, ingredient_name, quantity)
SELECT r.id, 'water', 50
FROM recipes r
WHERE r.name = 'espresso';

INSERT INTO recipe_ingredients (recipe_id, ingredient_name, quantity)
SELECT r.id, 'coffee', 20
FROM recipes r
WHERE r.name = 'espresso';

INSERT INTO recipe_ingredients (recipe_id, ingredient_name, quantity)
SELECT r.id, 'water', 150
FROM recipes r
WHERE r.name = 'americano';

INSERT INTO recipe_ingredients (recipe_id, ingredient_name, quantity)
SELECT r.id, 'coffee', 20
FROM recipes r
WHERE r.name = 'americano';

INSERT INTO recipe_ingredients (recipe_id, ingredient_name, quantity)
SELECT r.id, 'water', 50
FROM recipes r
WHERE r.name = 'cappuccino';

INSERT INTO recipe_ingredients (recipe_id, ingredient_name, quantity)
SELECT r.id, 'coffee', 20
FROM recipes r
WHERE r.name = 'cappuccino';

INSERT INTO recipe_ingredients (recipe_id, ingredient_name, quantity)
SELECT r.id, 'milk', 50
FROM recipes r
WHERE r.name = 'cappuccino';