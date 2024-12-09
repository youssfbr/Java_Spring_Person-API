ALTER TABLE IF EXISTS tb_customers_phones 
   ADD CONSTRAINT FK_tb_customers_phones_customer_id
   FOREIGN KEY (customer_id)
   REFERENCES tb_customers;