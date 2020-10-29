import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Row, Col, Alert } from 'react-bootstrap';
import Product from '../components/Product';

const HomeScreen = ({ match }) => {
  const keyword = match.params.keyword;

  const [products, setProducts] = useState([]);

  useEffect(() => {
    const fetchProducts = async () => {
      const { data } = await axios.get('/catalogue-service/p1/products/getAllProduct');
      const filteredProducts = [];
      if (keyword) {
        data.forEach((element) => {
          if (element.name.toLowerCase().includes(keyword.toLowerCase()))
            filteredProducts.push(element);
        });
        setProducts(filteredProducts);
      } else setProducts(data);
    };
    fetchProducts();
  }, [keyword]);

  document.title = "Home"

  if (products.length!==0) {
    return (
      <>
        <h1>Our Products</h1>
        <Row>
          {products.map((product) => (
            <Col key={product.id} sm={12} md={6} xl={3}>
              <Product product={product} />
            </Col>
          ))}
        </Row>
      </>
    );
  }

  
  else return(
    <Alert variant="warning">
      Sorry! No Products found
  </Alert>
  )

};

export default HomeScreen;
