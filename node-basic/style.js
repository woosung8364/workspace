// 스크롤 대상 객체를 선택합니다.
const box = document.getElementById('box'); // 박스 요소를 가져옵니다.
const area = document.getElementById('area'); // 드래그 가능한 영역 요소를 가져옵니다.

// 영역 및 박스의 크기를 가져옵니다.
const { width: areaWidth, height: areaHeight } = area.getBoundingClientRect();
const { width: boxWidth, height: boxHeight } = box.getBoundingClientRect();

// 드래그 상태와 초기 위치를 저장할 변수를 선언합니다.
let isDragging = null; // 드래그 중인지 여부를 나타내는 변수
let originLeft = null; // 박스의 초기 왼쪽 위치를 저장할 변수
let originTop = null; // 박스의 초기 위쪽 위치를 저장할 변수
let originX = null; // 마우스 클릭 위치 X 좌표를 저장할 변수
let originY = null; // 마우스 클릭 위치 Y 좌표를 저장할 변수

// 박스 요소에 마우스 다운 이벤트 리스너를 추가합니다.
box.addEventListener('mousedown', (e) => {
    isDragging = true; // 드래그 시작
    originX = e.clientX; // 마우스 클릭한 위치의 X 좌표 저장
    originY = e.clientY; // 마우스 클릭한 위치의 Y 좌표 저장
    originLeft = box.offsetLeft; // 박스의 현재 왼쪽 위치 저장
    originTop = box.offsetTop; // 박스의 현재 위쪽 위치 저장
    // 마우스 다운 시 클릭한 위치와 요소의 현재 위치 간의 차이를 계산합니다.
});

// 문서 전체에 마우스 이동 이벤트 리스너를 추가합니다.
document.addEventListener('mousemove', (e) => {
    if (isDragging) {
        // 마우스를 움직일 때 요소의 위치를 업데이트합니다.

        const diffX = e.clientX - originX; // X 축 이동 거리 계산
        const diffY = e.clientY - originY; // Y 축 이동 거리 계산
        const endOfXpoint = areaWidth - boxWidth; // X 축 최대 이동 범위 계산
        const endOfYpoint = areaHeight - boxHeight; // Y 축 최대 이동 범위 계산

        // 박스의 새로운 위치 설정, 최대 이동 범위 내에서 이동
        box.style.left = `${Math.min(Math.max(0, originLeft + diffX), endOfXpoint)}px`;
        box.style.top = `${Math.min(Math.max(0, originTop + diffY), endOfYpoint)}px`;
    }
});

// 문서 전체에 마우스 업 이벤트 리스너를 추가합니다.
document.addEventListener("mouseup", (e) => {
    isDragging = false; // 드래그 종료
});
