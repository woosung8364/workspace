import { useContext } from "react";
import { themeContext } from "../ContextExampleApp";
import { MemberContext } from "../ContextExampleApp";

function Headder() {
  const {isDark} = useContext(themeContext);
  const member = useContext(MemberContext);
  return (
    <header className="header" 
    style={{
      backgroundColor: isDark ? 'black' : 'gray',
      color: isDark ? 'white' : 'black',
    }}>
      <h1>환영합니다. 방그리님!</h1>
    </header>
  );
}

export default Headder;