import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import {
  Row,
  Col,
  Image,
  ListGroup,
  Card,
  Button,
  Form,
  Spinner,
} from 'react-bootstrap';

const ProductScreen = ({ match }) => {
  const [product, setProduct] = useState({
    price: { value: 0 },
    categories: [],
  });

  const [qty, setQty] = useState(1);

  useEffect(() => {
    const fetchProduct = async () => {
      const { data } = await axios.get(`/catalogue-service/p1/products/${match.params.id}`);
      setProduct(data);
    };
    fetchProduct();
  }, [match]);

  const addToCartHandler = () => {
    axios.post(`/cart-service/cart/addToCart/${product.id}/${qty}`);
  };

  if (product.price.value === 0) {
    const style = {
      position: 'fixed',
      top: '50%',
      left: '50%',
      transform: 'translate(-50%, -50%)',
    };
    return (
      <div style={style}>
        <Spinner animation='border' role='status'></Spinner>
      </div>
    );
  }

  document.title = product.name

  return (
    <>
      <Link to='/' className='btn btn-light my-3'>
        <i className='fas fa-arrow-left'></i> GO BACK
      </Link>
      <Row>
        <Col md={5}>
          <Image
            src='https://source.unsplash.com/random/600x600'
            alt={product.name}
            fluid
          />
        </Col>
        <Col md={3}>
          <ListGroup variant='flush'>
            <ListGroup.Item>
              <h2>{product.name}</h2>
            </ListGroup.Item>
            <ListGroup.Item>Price: €{product.price.value}</ListGroup.Item>
            <ListGroup.Item>
              Description: Lorem ipsum dolor sit amet consectetur adipisicing
              elit. Similique eum eaque ipsam quaerat veniam provident earum.
              Optio velit odit tempore cumque, aut reprehenderit natus veritatis
              minima voluptates sed Ipsam, soluta.
            </ListGroup.Item>
          </ListGroup>
        </Col>
        <Col md={4}>
          <Card>
            <ListGroup variant='flush'>
              <ListGroup.Item>
                <Row>
                  <Col>Categories:</Col>
                  <Col>
                    {product.categories.map((p) => (
                      <li key={p.id}>{p.name}</li>
                    ))}
                  </Col>
                </Row>
              </ListGroup.Item>
              <ListGroup.Item>
                <Row>
                  <Col>Status</Col>
                  <Col>
                    {product.quantity > 0 ? 'In Stock' : 'Out of Stock'}
                  </Col>
                </Row>
              </ListGroup.Item>
              {product.quantity > 0 && (
                <ListGroup.Item>
                  <Row>
                    <Col>Quantity:</Col>
                    <Col>
                      <Form.Control
                        as='select'
                        value={qty}
                        onChange={(e) => setQty(e.target.value)}
                      >
                        {[...Array(product.quantity).keys()].map((q) => (
                          <option key={q + 1} value={q + 1}>
                            {q + 1}
                          </option>
                        ))}
                      </Form.Control>
                    </Col>
                  </Row>
                </ListGroup.Item>
              )}
              <ListGroup.Item>
                <Button
                  onClick={addToCartHandler}
                  className='btn-block'
                  type='button'
                  disabled={product.quantity === 0}
                >
                  Add To Cart
                </Button>
              </ListGroup.Item>
            </ListGroup>
          </Card>
        </Col>
      </Row>
    </>
  );
};

export default ProductScreen;
