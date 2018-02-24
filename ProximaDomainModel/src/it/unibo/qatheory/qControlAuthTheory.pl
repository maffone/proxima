authorized(DOCTOR_ID, PATIENT_ID) :- 
			request(DOCTOR_ID, PATIENT_ID), doctor(DOCTOR_ID).
		
response(DOCTOR_ID, PATIENT_ID, NAME, SURNAME) :- 
			authorized(DOCTOR_ID, PATIENT_ID), data(PATIENT_ID, NAME, SURNAME).