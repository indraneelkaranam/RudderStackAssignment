import './App.css';
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import _ from "lodash";
import SourceType from "./SourceType";
import FieldSelector from "./FieldSelector";
import {useSearchParams} from "react-router-dom";

/**
 * Main App
 * @returns {JSX.Element}
 */
const App = () => {
    // list of source types to be displayed
    const [sourceTypes, setSourcesTypes] = useState([]);
    // current source Type
    const [currentSourceType, setCurrentSourceType] = useState("");
    // form data fetched based on source Type
    const [currentFormData, setCurrentFormData] = useState(null);
    // user responses for the form fecthed by source Type
    const [userFormData, setUserFormData] = useState({});
    // emulation of users
    const [searchParams] = useSearchParams();
    const userId = searchParams.get("userId");
    const baseURL = "http://localhost:8080/";

    /**
     * Update change in any field in the user responses
     * @param fieldKey -- field being changed
     * @param value -- changed value
     */
    const updateFormData = (fieldKey, value) => {
        setUserFormData({...userFormData, ...{[fieldKey]: value}});
    }

    /**
     * Handle submit
     * @param event
     */
    const updateUserInfo = (event) => {
        event.preventDefault();
        axios.post(`${baseURL}sourceType/${currentSourceType}/user/${userId}`, {
            ...userFormData,
        })
    }

    useEffect(() => {
        axios.get(`${baseURL}sourceTypes`).then(r => setSourcesTypes(r.data));
    }, [])

    useEffect(() => {
        axios.get(`${baseURL}formTemplate/${currentSourceType}`).then(r => setCurrentFormData(r.data));
        axios.get(`${baseURL}sourceType/${currentSourceType}/user/${userId}`).then(r =>
            setUserFormData(r.data))
    }, [currentSourceType])

    return (
        <div className="App">
            <form className="form" onSubmit={(event) => updateUserInfo(event)}>
                <div className="App-header">
                    <span className="form-text">Form</span>
                    <span className="source-drop-down"><SourceType
                        sourceTypes={sourceTypes}
                        setCurrentSourceType={(source) => setCurrentSourceType(source)}/>
                    </span>
                </div>
                {_.isNil(currentFormData) ? <div>Please Select a Source</div> :
                    <div>
                        {_.map(currentFormData?.fields, (value, key) => {
                            return <FieldSelector
                                fieldType={value.type}
                                fieldKey={key}
                                fieldDetails={value}
                                updateFormData={updateFormData}
                                userFormData={userFormData}
                            ></FieldSelector>
                        })}
                        <input type="submit" value="Submit" className="submit-button"/>
                    </div>
                }
            </form>
        </div>
    );
}

export default App;
