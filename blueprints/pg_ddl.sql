CREATE TRIGGER tr_base_product_update
BEFORE UPDATE ON base_product
FOR EACH ROW
BEGIN
    SET NEW.last_update = NOW();
END;
/