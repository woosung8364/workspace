import React, { createContext, useContext } from 'react';
import Content from "./Content";
import Footer from "./Footer";
import Headder from "./Headder";

function Page() {

  return (
    
    <div className="page" >
      <Headder  />
      <Content />
      <Footer />
    </div>
  );
}

export default Page;