// 사용자 정의 컴포넌트 정의
function MyButton(props) {

    // 읽어올때 쓰는것 , 값을 바꿀때 쓰는것 
    const [a, b] = React.useState(false);


    return React.createElement(
        'button',
        {
            onClick : () => {b(true)} ,
            style : {'background-color':'red', 
            'border' : '10px solid pink' ,
            'border-radius' : '10px'}
        },
        a ? '선택되었다' : '클릭해줘'
    );
}

const domContainer = document.querySelector("#root");
ReactDOM.render(React.createElement(MyButton), domContainer);