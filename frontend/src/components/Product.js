import React from 'react';
import { Card } from 'react-bootstrap';
import { Link } from 'react-router-dom'

const Product = ({ product }) => {
  return (
    <Card className='my-3 p-3 rounded'>
      <Link to={`/product/${product.id}`}>
        <Card.Img src='https://source.unsplash.com/random/600x600' varinat='top' />
      </Link>

      <Card.Body>
        <Link to={`/product/${product.id}`}>
          <Card.Title as='h5'>
            <strong>{product.name}</strong>
          </Card.Title>
        </Link>
        <Card.Text as='h3'>€{product.price.value} </Card.Text>
      </Card.Body>
    </Card>
  );
};

export default Product;
