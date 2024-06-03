% Function to calculate performance metrics and annotate plots
function annotate_performance(H, color)
    [y, t] = step(H);
    y_ss = y(end);
    y_max = max(y);
    a_sp = 1 - y_ss;
    sigma = (y_max - y_ss) / y_ss * 100;
    tolerance = 0.02;
    idx = find(abs(y - y_ss) <= tolerance * y_ss, 1, 'last');
    if isempty(idx)
        t_s = NaN;
    else
        t_s = t(idx);
    end
    
    % Plot step response
    step(H, color);
    hold on;
    
    % Annotate performance metrics
    annotation_str = sprintf('a_{sp}=%.2f, \\sigma=%.2f%%, t_s=%.2fs', a_sp, sigma, t_s);
    text(10, y_ss, annotation_str, 'Color', color);
end