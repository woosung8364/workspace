function Content({isDark}) {
  return (
    <div className="content" 
    style={{
      backgroundColor: isDark ? 'black' : 'lightgray',
      color: isDark ? 'white' : 'black',
    }}>
      <p>방그리님, 행복한 하루 되세요...</p>
    </div>
  );
}

export default Content;