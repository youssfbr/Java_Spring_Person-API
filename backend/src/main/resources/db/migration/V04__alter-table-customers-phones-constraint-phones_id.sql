ALTER TABLE IF EXISTS tb_customers_phones 
   ADD CONSTRAINT FK_tb_customers_phones_phones_id  
   FOREIGN KEY (phones_id) 
   REFERENCES tb_phones;