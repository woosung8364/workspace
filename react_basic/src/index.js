import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
// import './index2.css';
import reportWebVitals from './reportWebVitals';
// import ContextExampleApp from './ContextExampleApp';
// import App2 from './components/App2';
// import Redux from './components/Redux';
// import './Redux.css';
// import ReduxToolkitApp from './ReduxToolkitApp';
import BootstrapApp from './BootstrapApp';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render( <React.StrictMode> <BootstrapApp></BootstrapApp></React.StrictMode>);

reportWebVitals();
