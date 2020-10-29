import React from 'react';
import { Container } from 'react-bootstrap';
import { BrowserRouter, Route } from 'react-router-dom';

import Header from './components/Header';
import Footer from './components/Footer';
import HomeScreen from './screens/HomeScreen';
import ProductScreen from './screens/ProductScreen';
import AddProductScreen from './screens/AddProductScreen'
import CartScreen from './screens/CartScreen'
import OrderConfirmationScreen from './screens/OrderConfirmationScreen'

const App = () => {
  return (
    <BrowserRouter>
      <Header />
      <main className='py-3'>
        <Container>
          <Route path='/' exact component={HomeScreen} />
          <Route path='/product/:id' component={ProductScreen} />
          <Route path='/search/:keyword' component={HomeScreen}/> 
          <Route path='/cart' component={CartScreen} />
          <Route path='/order-confirmed' component={OrderConfirmationScreen}/> 
          <Route path='/AddProduct' component={AddProductScreen} />
        </Container>
      </main>
      <Footer />
    </BrowserRouter>
  );
};

export default App;


