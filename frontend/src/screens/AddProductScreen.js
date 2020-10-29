import React from 'react';
import { Form, Button } from 'react-bootstrap';

const AddProductScreen = () => {
  return (
    <div>
      <Form>
        <Form.Group controlId='formBasic'>
          <Form.Label>Name: </Form.Label>
          <Form.Control type='text' placeholder='Enter product name' />
        </Form.Group>

        <Form.Group controlId='formBasic'>
          <Form.Label>Price: </Form.Label>
          <Form.Control type='number' placeholder='Enter product price' />
        </Form.Group>

        <Form.Group controlId='formBasic'>
          <Form.Label>Quantity: </Form.Label>
          <Form.Control type='number' placeholder='Enter the quantity' />
        </Form.Group>

        <Form.Group controlId='formBasic'>
          <Form.Label>Version: </Form.Label>
          <Form.Control type='number' placeholder='Enter the version' />
        </Form.Group>

        <Button variant='primary' type='submit'>
          Submit
        </Button>
      </Form>
    </div>
  );
};

export default AddProductScreen;
