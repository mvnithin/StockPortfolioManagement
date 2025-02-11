CREATE DATABASE stock_portfolio;
USE stock_portfolio;

CREATE TABLE stocks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    stock_name VARCHAR(50),
    ticker_symbol VARCHAR(10),
    quantity INT,
    buy_price DOUBLE,
    buy_date DATE
);
