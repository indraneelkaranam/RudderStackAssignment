import React from "react";
import _ from 'lodash';

/**
 * Component for Check Box
 * @param props -- props containing field details, field key, user responses
 * @returns {JSX.Element}
 */
const CheckBoxField = (props) => {
    const {fieldDetails, fieldKey, updateFormData, userFormData} = props;
    return (
        <div className="field">
            <div className="label-div"><label className="label">{fieldDetails.label}</label></div>
            <div className="content-div">
                <input className="check-box-field"
                       type="checkbox"
                       checked={_.get(userFormData, fieldKey)}
                       onChange={(e) => {
                           updateFormData(fieldKey, e.target.checked);
                       }}
                />
            </div>
        </div>
    );
}

export default CheckBoxField;
