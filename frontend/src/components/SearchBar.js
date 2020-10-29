import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';

const SearchBar = ({ history }) => {
  const [keyword, setkeyword] = useState('');

  const submitHandler = (e) => {
    e.preventDefault();
    if (keyword.trim()) {
      history.push(`/search/${keyword}`);
    } else {
      history.push('/');
    }
  };

  return (
    <Form onSubmit={submitHandler} inline>
      <Form.Control
        type='text'
        name='q'
        onChange={(e) => setkeyword(e.target.value)}
        placeholder='Search products...'
        className='mr-sm-2 ml-sm-5'
        style={{width: '50%'}}
      ></Form.Control>
      <Button type='submit' variant='outline-secondary' className='p-2'>
        Search
      </Button>
    </Form>
  );
};

export default SearchBar;
