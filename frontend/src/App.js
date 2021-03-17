import React from "react";
import {UserContextProvider} from "./components/UserContext";
import {BrowserRouter, Route} from "react-router-dom";
import HomePage from "./components/HomePage";
import VideoPage from "./components/VideoPage";
import Header from "./components/Header";

import './App.css';

function App() {
	return (
		<div className="App">
			<UserContextProvider>
				<BrowserRouter>
					<header className="App-header">
						<Header />
						<Route exact path={["/", "/home"]} component={HomePage} />
						<Route path={"/video/:id"} component={VideoPage} />
					</header>
				</BrowserRouter>
			</UserContextProvider>
		</div>
	);
}

export default App;
