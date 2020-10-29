import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import {
  Row,
  Col,
  Alert,
  ListGroup,
  Image,
  Button,
  Card,
} from 'react-bootstrap';

const CartScreen = ({ history }) => {
  const [cartItems, setCartItems] = useState({ items: [] })

  useEffect(() => {
    const fetchCart = async () => {
      const cartRes = await axios.get('/cart-service/cart/retrieveCart');
      setCartItems(cartRes.data);
    }
    fetchCart();
  }, [cartItems]);


  const fetchCart = async () => {
    const cartRes = await axios.get('/cart-service/cart/retrieveCart');
    setCartItems(cartRes.data);
  }


  const removeFromCartHandler = async (id) => {
    await axios.post(`/cart-service/cart/removeItemFromCart/${id}`);
    fetchCart()
  };

  const checkoutHandler = () => {
    
    history.push('/order-confirmed');
  };

  document.title = "Your Cart"

  return (
    <Row>
      <Col md={8}>
        <h1>Shopping Cart</h1>
        {cartItems.items.length === 0 ? (
          <Alert variant='info'>
            Your cart is empty.    <Link to='/'><u>Continue Shoppping?</u></Link>
          </Alert>
        ) : (
            <ListGroup variant='flush'>
              {cartItems.items.map((item) => (
                <ListGroup.Item key={item.id}>
                  <Row>
                    <Col md={2}>
                      <Link to={`/product/${item.id}`}>
                        <Image
                          src='https://source.unsplash.com/random/600x600'
                          alt={item.name}
                          fluid
                          rounded
                        />
                      </Link>
                    </Col>
                    <Col md={3}>
                      <Link to={`/product/${item.id}`}>{item.name}</Link>
                    </Col>
                    <Col md={2}>€{item.price.value}</Col>
                    <Col md={2}>
                      {/* <Form.Control as='select'>
                        {[...Array(item.quantity).keys()].map((q) => (
                          <option key={q + 1} value={q + 1}>
                            {q + 1}
                          </option>
                        ))}
                      </Form.Control> */}
                      {(item.quantity > 1) ? <p>No</p> : <p>Nos</p>}
                      <p>{item.quantity}</p>
                    </Col>
                    <Col md={2}>
                      <Button
                        type='button'
                        variant='light'
                        onClick={() => removeFromCartHandler(item.id)}
                      >
                        <i className='fas fa-trash'></i>
                      </Button>
                    </Col>
                  </Row>
                </ListGroup.Item>
              ))}
            </ListGroup>
          )}
      </Col>
      { cartItems.items.length &&
        <Col md={4}>
          <Card>
            <ListGroup variant='flush'>
              <ListGroup.Item>
                <h2>
                  Subtotal (
                {cartItems.items.reduce((acc, cur) => acc + cur.quantity, 0)} items
                )
              </h2>
              €
              {cartItems.items
                  .reduce((acc, cur) => acc + cur.quantity * cur.price.value, 0)
                  .toFixed(2)}
              </ListGroup.Item>


              <ListGroup.Item>
                <Button
                  type='button'
                  className='btn-block'
                  disabled={cartItems.items.length === 0}
                  onClick={checkoutHandler}
                >
                  PLACE YOUR ORDER
              </Button>
              </ListGroup.Item>

            </ListGroup>
          </Card>
        </Col>
      }
    </Row>
  );
};

export default CartScreen;
