const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
    app.use(createProxyMiddleware("/bom-api/boms/health", { target: "http://localhost:8081" }));
};
