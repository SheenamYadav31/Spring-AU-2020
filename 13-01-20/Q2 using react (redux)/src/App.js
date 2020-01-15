import React from 'react';
import logo from './logo.svg';
import './App.css';
import MyComponent from './MyComponent';


function App() {
  return (
    <div className="App">
      <header>
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Hello from Sheenam
        </p>
      </header>
      <MyComponent />
    </div>
  );
}

export default App;
