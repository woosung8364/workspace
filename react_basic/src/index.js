import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import './index2.css';
import reportWebVitals from './reportWebVitals';
import ContextExampleApp from './ContextExampleApp';
import App2 from './components/App2';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render( <React.StrictMode> <App2></App2></React.StrictMode>);

reportWebVitals();
