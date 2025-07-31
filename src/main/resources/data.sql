INSERT INTO inventory (description, name, price)
SELECT * FROM (
                  VALUES
                      ('for writing', 'pencil', 50000),
                      ('for ruling', 'ruler', 10000),
                      ('for taking notes', 'book', 60000),
                      ('for drawing', 'drawing-pad', 80000),
                      ('for packing lunch', 'lunchbox', 90000)
              ) AS new_items(description, name, price)
WHERE NOT EXISTS (
    SELECT 1 FROM inventory WHERE inventory.name = new_items.name
);