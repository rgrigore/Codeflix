import React from "react";
import {UserContextProvider} from "./components/UserContext";
import {BrowserRouter, Route} from "react-router-dom";
import HomePage from "./components/HomePage";

function App() {
	return (
		<div className="App">
			<UserContextProvider>
				<BrowserRouter>
					<Route exact path={["/", "/home"]} component={HomePage} />
					{/*<Route path={"/video/:id"} component={} />*/}
				</BrowserRouter>
			</UserContextProvider>
		</div>
	);
}

export default App;
