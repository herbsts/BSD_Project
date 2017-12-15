BEGIN
    DBMS_SCHEDULER.CREATE_JOB (
            job_name => '"BOOSTL"."JOB_ACC_WORDS"',
            job_type => 'STORED_PROCEDURE',
            job_action => 'BOOSTL.PRO_SET_ACCURACY_WORDS',
            number_of_arguments => 2,
            start_date => TO_TIMESTAMP_TZ('2017-12-01 11:06:26.000000000 EUROPE/BERLIN','YYYY-MM-DD HH24:MI:SS.FF TZR'),
            repeat_interval => 'FREQ=DAILY;BYDAY=MON,TUE,WED,THU,FRI,SAT,SUN;BYHOUR=3;BYMINUTE=0;BYSECOND=0',
            end_date => NULL,
            enabled => FALSE,
            auto_drop => FALSE,
            comments => 'Decreases the accuracy of words');

    DBMS_SCHEDULER.SET_JOB_ARGUMENT_VALUE( 
             job_name => '"BOOSTL"."JOB_ACC_WORDS"', 
             argument_position => 1, 
             argument_value => '3');
    DBMS_SCHEDULER.SET_JOB_ARGUMENT_VALUE( 
             job_name => '"BOOSTL"."JOB_ACC_WORDS"', 
             argument_position => 2, 
             argument_value => '5');
         
     
 
    DBMS_SCHEDULER.SET_ATTRIBUTE( 
             name => '"BOOSTL"."JOB_ACC_WORDS"', 
             attribute => 'logging_level', value => DBMS_SCHEDULER.LOGGING_OFF);
      
  
    
    DBMS_SCHEDULER.enable(
             name => '"BOOSTL"."JOB_ACC_WORDS"');
END;