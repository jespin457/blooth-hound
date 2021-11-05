const path = require('path');

module.exports = {
  mode: process.env.NODE_ENV, //either DEV or PRODUCTION
  entry: './client/index.js',
  output: { //where the bundled files will compile
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'build')
  },
  module: {
    rules: [
      {
        test: /\.jsx?/,
        exclude: /node_modules/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: ['@babel/preset-env', '@babel/preset-react'],
          }
        }
      },
      {
        test: /\.css$/i,
        use: ['style-loader', 'css-loader', 'sass-loader'],
      },
    ]
  },
  devServer: {
    port: 8080,
    publicPath: 'build',
    proxy: {
      '/': 'http://localhost.com:3000'
    },
    compress: true,
    hot: true
  }
}