-- 1. Insertar productos
INSERT INTO Tiendadb.products (product_name, product_code, product_description, product_price) VALUES
('Laptop Pro 15', 'LP-15-001', 'Portatil de alta gama con 16GB RAM y 512GB SSD', 1299.99),
('Ratón Inalámbrico', 'MS-WL-002', 'Ratón ergonómico con conexión Bluetooth', 29.99),
('Teclado Mecánico RGB', 'KB-RGB-003', 'Teclado mecánico switches rojos retroiluminado', 89.99);

-- 2. Insertar cuentas/usuarios
INSERT INTO Tiendadb.accounts (account_name, account_email, account_address) VALUES
('Ana Pérez', 'ana.perez@example.com', 'Calle Falsa 123, Madrid'),
('Carlos Gómez', 'carlos.gomez@example.com', 'Av. Principal 456, Barcelona');

-- 3. Insertar listas de deseos (wishlists) - Después de products y accounts
INSERT INTO Tiendadb.wishlists (account_id, product_id) VALUES
(1, 2), -- Ana Pérez añade el Ratón Inalámbrico
(2, 1); -- Carlos Gómez añade el Portatil Pro 15

-- 4. Insertar pedidos (orders)
INSERT INTO Tiendadb.orders (account_id, status) VALUES
(1, 'PAID'),
(2, 'PENDING');

-- 5. Insertar ítems de los pedidos (order_items)
INSERT INTO Tiendadb.order_items (order_id, product_id, quantity, unit_price) VALUES
(1, 1, 1, 1299.99), -- 1 Portatil para el pedido 1
(1, 2, 2, 29.99),  -- 2 Ratón para el pedido 1
(2, 3, 1, 89.99);  -- 1 Teclado para el pedido 2

-- 6. Insertar facturas (invoices)
INSERT INTO Tiendadb.invoices (order_id, total_amount) VALUES
(1, 1359.97),
(2, 89.99);
