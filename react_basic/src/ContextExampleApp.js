import { createContext, useState } from 'react';
import './App.css';
import Page from './components/Page';

export const themeContext = createContext(null);
export const MemberContext = createContext(null);
export default ContextExampleApp;


function ContextExampleApp() {
  const [isDark, setIsDark] = useState(false); 
  return (
    <MemberContext.Provider value={'김기정'}>
    <themeContext.Provider value={{isDark , setIsDark}}>
    <Page />
    </themeContext.Provider>
    </MemberContext.Provider>
  );
}


