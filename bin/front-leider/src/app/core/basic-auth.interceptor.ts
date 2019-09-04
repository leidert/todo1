import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class BasicAuthInterceptor implements HttpInterceptor {
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add authorization header with basic auth credentials if available
        let currentUser = sessionStorage.getItem('auth');


        let headers: HttpHeaders;
        // headers = request.headers.set('Authorization', [currentUser]);
        headers = request.headers.set('Content-Type', 'application/json');

        request = request.clone({
            // headers: request.headers.set('Authorization', [currentUser]),     
            headers: headers,
        });
        return next.handle(request);
    }
    
}