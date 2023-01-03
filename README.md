<img width="490" alt="Screenshot 2023-01-04 at 1 06 46 AM" src="https://user-images.githubusercontent.com/43849911/210428717-c5923720-aebd-4d47-b301-242421076578.png">

```
Fixed Delay parameter at @Scheduled annotation will add a delay between two executions or methods.

One Method needs to wait for previous one's execution to be completed.

Fixed Delay guarantees that method execution is going to be happened.
```

```
In Fixed Rate , method is going to be executed after the defined time without any delay even if previous one isn't executed.
```

<img width="714" alt="Screenshot 2023-01-04 at 1 20 25 AM" src="https://user-images.githubusercontent.com/43849911/210430755-81767d08-419f-4ba7-ba81-763b479932d3.png">

<img width="999" alt="Screenshot 2023-01-04 at 1 20 49 AM" src="https://user-images.githubusercontent.com/43849911/210430807-ed931fcf-0d14-4bff-ae98-887c9a01d676.png">

<img width="783" alt="Screenshot 2023-01-04 at 1 46 14 AM" src="https://user-images.githubusercontent.com/43849911/210434462-50550690-a209-4f2d-b20d-476b170c0dd2.png">

<img width="1103" alt="Screenshot 2023-01-04 at 1 46 50 AM" src="https://user-images.githubusercontent.com/43849911/210434511-0150e0d1-1911-4d2a-9e30-c434f25e5409.png">

<img width="816" alt="Screenshot 2023-01-04 at 1 56 53 AM" src="https://user-images.githubusercontent.com/43849911/210435937-97f4b56b-b152-422e-ad82-50a1c1a1a6b0.png">

```
for larger rates
executed after every 2 hours PT02H ( PT02S )
```

<img width="780" alt="Screenshot 2023-01-04 at 2 02 13 AM" src="https://user-images.githubusercontent.com/43849911/210436690-0e851594-62be-41aa-bfbb-67f85e369ba9.png">

```
For parallel execution we need to use @Async Annotation
```

<img width="771" alt="Screenshot 2023-01-04 at 2 04 19 AM" src="https://user-images.githubusercontent.com/43849911/210437028-2db6b657-271b-4e8d-a9de-c0374ff83625.png">

<img width="1137" alt="Screenshot 2023-01-04 at 2 05 06 AM" src="https://user-images.githubusercontent.com/43849911/210437123-add51be7-410a-4664-a8f1-8ecf91cf0fa1.png">

