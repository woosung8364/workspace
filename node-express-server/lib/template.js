const path = require("path");
module.exports = {
    list: function (fileList) {
        let list = '<ul>';
        fileList.forEach(fileName => {
            // 확장자 제거 파일 이름
            let baseName = path.basename(fileName, '.html');
            list = list + `<li><a href="/read/${baseName}">${baseName}</a></li>`;
        });
        list = list + '</ul>';
        return list;
    },
    toHtml: function (title, list, control, contents) {
        return `
        <!doctype html>
        <html>
            <head>
                <title>WEB1 - ${title}</title>
                <meta charset="utf-8">
            </head>
            <body>
                <h1><a href="/">Home</a></h1>
                ${list}
                ${control}
                ${contents}
            </body>
        </html>
        `;
    }
}
